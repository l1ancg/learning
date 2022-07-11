!#/bin/bash

# For Linux x86_64 (amd64)
curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 && \
sudo install skaffold /usr/local/bin/

rm -rf skaffold

skaffold config set --global local-cluster true

skaffold version