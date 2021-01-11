import { useIsFocused, useNavigation } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { ScrollView, Alert, Text } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import Header from '../../components/Header';
import OrderCard from '../../components/OrderCard';
import { fetchOrders } from '../../service/api';
import { Order } from '../../service/types';


import styles from './styles';

const Orders: React.FC = () => {

  const [orders, setOrders] = useState<Order[]>([]);
  const [isLoading, setIsLoading] = useState(false);
  const navigation = useNavigation();
  const isFocused = useIsFocused();

  const fetchData = () => {
    setIsLoading(true);
    fetchOrders()
      .then(response => setOrders(response.data))
      .catch(error => Alert.alert('Houve um erro ao buscar os pedidos!'))
      .finally(() => setIsLoading(false));
  }

  useEffect(() => {
    if (isFocused) {
      fetchData();
    }
  }, [isFocused]);

  const handleOnPress = (order: Order) => {
    navigation.navigate('OrderDetails', {
      order
    });
  }
  return (
    <>
      <Header />
      <ScrollView
        showsVerticalScrollIndicator={false}
        style={styles.container}
      >
        {isLoading ? (
          <Text style={styles.text}>Buscando Pedidos...</Text>
        ) : (
            orders.map(order => (
              <TouchableWithoutFeedback
                onPress={() => handleOnPress(order)}
                key={order.id}
              >
                <OrderCard order={order} />
              </TouchableWithoutFeedback>
            ))
          )}
      </ScrollView>
    </>
  );
}

export default Orders;