from faker import Faker
import json

fake = Faker()

# load environment variables
from dotenv import load_dotenv
import os
load_dotenv()

def generate_product_data(n):
    products = []
    for _ in range(n):
        product = {
            "id": fake.uuid4(),
            "name": fake.word().capitalize(),
            "description": fake.text(),
            "price": round(fake.random_number(digits=5) * 0.01, 2),
            "inStock": fake.boolean(),
            "imageUrl": fake.image_url()  # Add an image URL for each product
        }
        products.append(product)
    return products

def save_to_json(file_path, data):
    with open(file_path, 'w') as f:
        json.dump(data, f, indent=4)

# Use environment variables for configuration
ROOT_DIR = os.path.dirname(
    os.path.abspath(__file__)
)
output_file_path =  os.path.join(ROOT_DIR, 'data', os.getenv('OUTPUT_FILE_NAME', 'default_products.json'))
number_of_products = int(os.getenv('NUMBER_OF_PRODUCTS', 10))

# Generate products based on configuration
sample_products = generate_product_data(number_of_products)
save_to_json(output_file_path, sample_products)