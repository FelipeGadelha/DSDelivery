import React, { useEffect, useState } from 'react';
import fetchProducts from '../../service/api';
import OrderLocation from './OrderLocation';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import { orderLocationdata, Product } from './types';

import './styles.css';

const Orders: React.FC = () => {
    const [products, setProducts] = useState<Product[]>([]);   
    const [orderLocation, setOrderLocation] = useState<orderLocationdata>();   
    console.log(products);

    useEffect(() =>{
        fetchProducts()
        .then(response => setProducts(response.data))
        .catch(error => console.log(error))
    }, []);

  return (
      <div className="orders-container">
          <StepsHeader />
          <ProductsList products={ products }/>
          <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
      </div>
  );
}

export default Orders;