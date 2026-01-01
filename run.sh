#!/usr/bin/env bash
set -euo pipefail

if [ -f .env ]; then
  export $(grep -v '^#' .env | xargs)
fi

: "${SONAR_HOST_URL:?Missing SONAR_HOST_URL}"
: "${SONAR_PROJECT_KEY:?Missing SONAR_PROJECT_KEY}"
: "${SONAR_TOKEN:?Missing SONAR_TOKEN}"

docker compose up -d

mvn clean verify sonar:sonar \
  -Dsonar.projectKey="$SONAR_PROJECT_KEY" \
  -Dsonar.host.url="$SONAR_HOST_URL" \
  -Dsonar.token="$SONAR_TOKEN"

echo "✅ Done. Open $SONAR_HOST_URL"
