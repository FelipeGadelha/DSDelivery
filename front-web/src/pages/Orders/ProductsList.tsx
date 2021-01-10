import React from 'react';
import { checkIsSeleted } from './helpers';
import ProductCard from './ProductCard';
import { Product } from './types';

interface ProductsListProps {
  products: Product[];
  selectedProducts: Product[];
  onSelectProduct: (product: Product) => void;
}

const ProductsList = ({ products, selectedProducts, onSelectProduct }: ProductsListProps) => {
  return (
      <div 
        className="orders-list-container"
      >
          <div className="orders-list-items">
           {products.map(product => (
             <ProductCard 
              key={product.id} 
              product={ product }
              onSelectProduct={onSelectProduct}
              isSelected={checkIsSeleted(selectedProducts, product)}
            />
           ))}
          </div>
      </div>
  );
}
export default ProductsList;