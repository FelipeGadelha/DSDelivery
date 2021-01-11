import axios from "axios";

const API_URL = 'https://imersao-dev-ds-delivery.herokuapp.com/api/dsdelivery';

export function fetchOrders() {
    return axios(`${API_URL}/v1/orders`)
}

export function confirmDelivery(orderId: number) {
    return axios.put(`${API_URL}/v1/orders/${ orderId }/delivered`)
}