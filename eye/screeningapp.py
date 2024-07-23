from flask import Flask, request, jsonify
import numpy as np
from PIL import Image
from io import BytesIO
import base64

app = Flask(__name__)

def preprocess_image(image):
    return np.array(image)

@app.route("/",methods=['GET'])
def hello():
    return render_template('index1.html')

@app.route('/upload', methods=['POST'])
def upload_image():
    file = request.files['image']
    img_bytes = file.read()
    img = Image.open(BytesIO(img_bytes))
    img_array = preprocess_image(img)
    result = "Image uploaded successfully!"
    return jsonify({'result': result})

if __name__ == '__main__':
    app.run(debug=True)