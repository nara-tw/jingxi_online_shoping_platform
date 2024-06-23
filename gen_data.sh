#!/bin/bash

# Define variables for directories and files
PYTHON_SCRIPT_PATH="/Users/naranarawittubtimtoe/Desktop/programming/gs-spring-boot-main/initial/src/main/python/getProductData.py"

# Function for executing the Python script
run_python() {
    source /Users/naranarawittubtimtoe/Desktop/programming/gs-spring-boot-main/initial/product_utils_venv/bin/activate
    python3 -m pip install Faker
    python3 -m pip install python-dotenv
    python3 $PYTHON_SCRIPT_PATH
}

# Call functions to execute tasks
run_python
