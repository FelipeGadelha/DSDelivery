import React from 'react';
//import { ReactComponent as Pizza } from '../../assets/pizza.svg';
import { Product } from './types';


interface ProductProps {
    product: Product;
}

function formatPrice(price: number) {
    const formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
        //minimumFractionDigits: 3
    })
    return formatter.format(price);
}

const ProductCard: React.FC<ProductProps> = (props) => {
  return (

      <div className="order-card-container">
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