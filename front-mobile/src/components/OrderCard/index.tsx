import React from 'react';
import { Text, View } from 'react-native';
import { Order } from '../../service/types';
import 'intl';
import 'intl/locale-data/jsonp/pt-BR';
import dayjs from 'dayjs';
import 'dayjs/locale/pt-br';
import relativeTime from 'dayjs/plugin/relativeTime';

import styles from './styles';

dayjs.locale('pt-br')
dayjs.extend(relativeTime);

interface OrderCardProps {
  order: Order;
}

function dateFromNow(date: string) {
  return dayjs(date).fromNow();
}

export function formatPrice(price: number) {
  const formatter = new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL',
      //minimumFractionDigits: 3
  })
  return formatter.format(price);
}

const OrderCard: React.FC<OrderCardProps> = (props) => {
  return (
      <View style={styles.container}>
          <View style={styles.header}>
            <Text style={styles.orderName}>Pedido {props.order.id}</Text>
            <Text style={styles.orderPrice}>{formatPrice(props.order.total)}</Text>
          </View>
          <Text style={styles.text}>{dateFromNow(props.order.moment)}</Text>
          <View style={styles.productsList}>
            {props.order.products.map(product => (
              <Text key={product.id} style={styles.text}>{product.name}</Text>
            ))}
          </View>
      </View>
  );
}

export default OrderCard;