import React from 'react';
import { Product } from '../../service/types';
import { formatPrice } from './helpers';
//import { ReactComponent as Pizza } from '../../assets/pizza.svg';

interface ProductProps {
    product: Product;
    onSelectProduct: (product: Product) => void;
    isSelected: boolean;
}

const ProductCard: React.FC<ProductProps> = (props) => {
  return (

      <div 
        className={`order-card-container ${props.isSelected ? 'selected': ''}`}
        onClick={() => props.onSelectProduct(props.product)}    
        >
        <h3 className="order-card-title">
            {props.product.name}
        </h3>
        {/* <Pizza className="order-card-image"/> */}
        <img
            src={props.product.imageUri} 
            className="order-card-image"
            alt={props.product.name}
        />
        <h3 className="order-card-price">
            {formatPrice(props.product.price)}
        </h3>
        <div className="order-card-description">
            <h3>Descrição</h3>
            <p>
                {props.product.description}
            </p>
        </div>
      </div>
  );
}

export default ProductCard;