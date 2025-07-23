# QRservice
![Static Badge](https://img.shields.io/badge/QRService-v1.0%20-%20%230080ffcc?style=flat-square)

This project is an API that generates QR codes based on the link provided by the user. It is built using Spring Boot and the Zxing QR encoding library.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Overview

The QR Code Generator API allows users to create QR codes by providing a URL or any other text content. The API supports customization of QR code size, image type, and error correction level.

## Features

- Generate QR codes from provided content
- Customize QR code size, image type, and error correction level
- Health check endpoint to verify API status

## Installation

To run this project locally, follow these steps:

1. Clone the repository:
    ```sh
    git clone https://github.com/7aviel/QRservice.git
    ```
2. Navigate to the project directory:
    ```sh
    cd QRService
    ```
3. Build the project using gradle:
    ```sh
    gradle clean build
    ```
4. Run the Spring Boot application:
    ```sh
    gradle bootRun
    ```

## Usage

Once the application is running, you can use the API to generate QR codes.

## API Endpoints

### Health Check

- **Endpoint:** `/api/health`
- **Method:** `GET`
- **Description:** Check the health status of the API.
- **Response:** `200 OK`

### Generate QR Code

- **Endpoint:** `/api/qrcode`
- **Method:** `GET`
- **Parameters:**
  - `size` (Integer) - The size of the QR code (optional, default is 250)
  - `type` (String) - The image type of the QR code (optional, default is "png")
  - `correction` (String) - The error correction level (optional). Accepted values are L, M, Q, H:
    - `L` - Low (7% of codewords can be restored)
    - `M` - Medium (15% of codewords can be restored)
    - `Q` - Quartile (25% of codewords can be restored)
    - `H` - High (30% of codewords can be restored)
  - `content` (String) - The content to encode in the QR code (required)
- **Response:** A QR code image in the specified format.

Example request:
```sh
curl -X GET "http://localhost:8080/api/qrcode?content=https://example.com"
```

