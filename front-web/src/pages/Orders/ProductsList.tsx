import React from 'react';
import ProductCard from './ProductCard';
import { Product } from './types';

interface ProductsListProps {
  products: Product[];
}

const ProductsList = (Props: ProductsListProps) => {
  return (
      <div className="orders-list-container">
          <div className="orders-list-items">
           {Props.products.map(product => (
             <ProductCard key={product.id} product={ product }/>
           ))}
          </div>
      </div>
  );
}
export default ProductsList;