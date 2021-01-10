import React from 'react';
import { defaultProps } from 'react-select/src/Select';
import { formatPrice } from './helpers';

interface OrderSummaryProps {
    amount: number;
    totalPrice: number;
    onSubmit: () => void;
}


const OrderSummary: React.FC<OrderSummaryProps> = (props) => {
  return (
        <div className="order-summary-container">
            <div className="order-summary-content">
                <div>
                    <span className="amount-selected-container">
                        <strong className="amount-selected">{props.amount}</strong>
                        PEDIDOS SELECIONADOS
                    </span>
                    <span className="order-summary-total">
                        <strong className="amount-selected">
                            {formatPrice(props.totalPrice)}
                        </strong>
                        VALOR TOTAL
                    </span>
                </div>
                <button 
                    className="order-summary-make-order"
                    onClick={ props.onSubmit }    
                >
                    FAZER PEDIDO
                </button>
            </div>
        </div>
    );
}

export default OrderSummary;