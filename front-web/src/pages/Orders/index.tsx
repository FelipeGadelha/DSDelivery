import React, { useEffect, useState } from 'react';
import fetchProducts from '../../service/api';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';

import './styles.css';
import { Product } from './types';

const Orders: React.FC = () => {
    const [products, setProducts] = useState<Product[]>([]);   
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
      </div>
  );
}

export default Orders;