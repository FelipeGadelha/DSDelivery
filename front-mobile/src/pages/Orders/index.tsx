import React from 'react';
import { Text, View, ScrollView } from 'react-native';
import Header from '../../components/Header';
import OrderCard from '../../components/OrderCard';


import styles from './styles';

const Orders: React.FC = () => {
  return (
      <>
      <Header/>
      <ScrollView 
        showsVerticalScrollIndicator={false} 
        style={styles.container}
        >
          <OrderCard />
          <OrderCard />
          <OrderCard />
          <OrderCard />
          <OrderCard />
      </ScrollView>
      </>
  );
}

export default Orders;