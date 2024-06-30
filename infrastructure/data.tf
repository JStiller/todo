data "aws_region" "current" {}
data "aws_caller_identity" "current" {}

locals {
  common_tags = {
    Owner       = var.biz_owner
    Environment = var.tech_environment
    Version     = var.tech_version
    Project     = var.biz_project
  }

  prefix = "${var.biz_project}-${local.var.tech_environment}"
}