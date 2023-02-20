## A new way to deploy applications

This enables continuous deployment strategy and ensures that we're meeting SLOs

1. Check if the App is ready to accept request.
2. Generate HTTP/gRPC load.
3. Collect Metrics from Prometheus API/Metrics Server.
4. Compare and Validate SLOs. Can be visualized in Grafana (Prometheus-like results) or in WebUI.
5. Roll back or Promote it using pipeline, GitOps or any other method of deployment.
