variable "biz_owner" {
  description = "To which owner does this project belong?"
  type        = string
  default     = "Me"

  validation {
    condition     = length(var.biz_owner) >= 3 && length(var.biz_owner) <= 40
    error_message = "There are only the following environments available: production, stage and development. Default is production."
  }
}

variable "biz_project" {
  description = "To which project should everything be assigned?"
  type        = string

  validation {
    condition     = length(var.biz_project) >= 3 && length(var.biz_project) <= 40
    error_message = "The project name must be at least 3 and at most 20 characters long."
  }
}

variable "tech_environment" {
  description = "In which environment should the infrastructure be deployed?"
  type        = string
  default     = "production"

  validation {
    condition     = contains(["production", "stage", "development"], var.tech_environment)
    error_message = "There are only the following environments available: production, stage and development. Default is production."
  }
}

variable "tech_version" {
  description = "To which version is this related?"
  type        = string

  validation {
    condition     = can(regex("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$", var.tech_version))
    error_message = "Must be valid semantic version."
  }
}

variable "tech_aws_region" {
  description = "To which aws region should everything be deployed?"
  type        = string
  default     = "eu-central-1"

  validation {
    condition     = startswith(var.tech_aws_region, "eu") && length(var.tech_aws_region) >= 3 && length(var.tech_aws_region) <= 20
    error_message = "The aws region must be within europe and one of the following: Central, West, South or North."
  }
}

variable "tech_branch" {
  description = "In which branch should the infrastructure be related?"
  type        = string

  validation {
    condition     = length(var.tech_branch) >= 3 && length(var.tech_branch) <= 200
    error_message = "The branch name must be at least 3 and at most 200 characters long."
  }
}
