# run.ps1
$ErrorActionPreference = "Stop"

# Charge .env si présent
if (Test-Path ".env") {
  Get-Content ".env" | ForEach-Object {
    if ($_ -match "^\s*#") { return }
    if ($_ -match "^\s*$") { return }
    $pair = $_.Split("=",2)
    [System.Environment]::SetEnvironmentVariable($pair[0].Trim(), $pair[1].Trim())
  }
}

$hostUrl = $env:SONAR_HOST_URL
$projectKey = $env:SONAR_PROJECT_KEY
$token = $env:SONAR_TOKEN

if ([string]::IsNullOrWhiteSpace($hostUrl) -or [string]::IsNullOrWhiteSpace($projectKey) -or [string]::IsNullOrWhiteSpace($token)) {
  Write-Host " Remplis .env avec SONAR_HOST_URL, SONAR_PROJECT_KEY, SONAR_TOKEN"
  exit 1
}

Write-Host "== Start SonarQube (docker compose) =="
docker compose up -d

Write-Host "== Analyse Maven =="
# Place-toi dans le dossier de ton projet Maven (où il y a pom.xml) avant d'exécuter run.ps1
mvn clean verify sonar:sonar `
  -Dsonar.projectKey=$projectKey `
  -Dsonar.host.url=$hostUrl `
  -Dsonar.token=$token

Write-Host " Done. Open $hostUrl"
