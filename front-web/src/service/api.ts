import axios from "axios";

const API_URL = "http://localhost:8080/api/dsdelivery";

export default function fetchProducts() {
    return axios(`${API_URL}/v1/products`);
}

