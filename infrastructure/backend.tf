terraform {
  backend "s3" {
    encrypt        = true
    bucket         = "terraform-state"
    key            = "terraform.tfstate"
    region         = "eu-central-1"
    dynamodb_table = "terraform-state-lock"
  }
}