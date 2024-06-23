#!/bin/bash

# Define variables for directories and files
PYTHON_SCRIPT_PATH="/src/main/python/getProductData.py"

# Function for building the Java project
build_java() {
    ./gradlew bootRun
}

# Function for executing the Python script
run_python() {
    python3 $PYTHON_SCRIPT_PATH
}

# Call functions to execute tasks
run_python
build_java
