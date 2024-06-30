// e.g. aws

provider "aws" {
  region = var.tech_aws_region
  default_tags {
    tags = local.common_tags
  }
}
