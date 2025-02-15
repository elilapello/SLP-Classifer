# Single Layer Perceptron Classifier
A Single Layer Perceptron implemented from scratch in Java that classifies handwritten 0s and 1s from the [MNIST in CSV](https://www.kaggle.com/datasets/oddrationale/mnist-in-csv) dataset.
## Coding Process
### 1. Data Preprocessing
The MNIST dataset consists of 28x28 greyscale images of handwritten numbers 0-9. For this project I went with binary classification of only handwritten 0s and 1s. The 28x28 images were flattened into 784 pixel value arrays, and normalized by dividing each value by 255. This was done to increase model performance by reducing scaling effects.
### 2. Model Architecture
I went with a Single Layer Perceptron for this project due to its simplicty and performance for binary classification tasks. Each input neuron in the perceptron corresponds to one pixel value in the image. There is a single output neuron that classifies the image as either a 0 or 1 after being passed through a step function.
### 3. Training the Perceptron
During training the perceptrona adjusts its weights based on the error calculated between its prediction and the correct label. The perceptron was trained by iterating over the entire training dataset for a set number of epochs. I found that increasing the number of epochs provided minimal to no improvement of performance. 
### 4. Testing and Evaluation
After the perceptron was trained I tested it on unseen data from the testing portion of the MNIST dataset. The perceptron correctly classified ~99.91% of images it was given.
![Percent Image](images/percent_classified.jpg)
### Future Improvements
- Expand the model to classify digits 0-9 from MNSIT
- Implement a multi-layer perceptron
- Implement a different activation function like sigmoid for added non-linearity

