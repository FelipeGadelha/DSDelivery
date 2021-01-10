export type Product = {
    id: number;
    name: string;
    price: number;
    description: string;
    imageUri: string;
}

export type orderLocationData = {
    latitude: number;
    longitude: number;
    address: string;
}

type ProducId = {
    id: number;
}

export type OrderPayload = {
    products: ProducId[];
} & orderLocationData;