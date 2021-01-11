import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Alert, Linking, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import Header from '../../components/Header';
import OrderCard from '../../components/OrderCard';
import { confirmDelivery } from '../../service/api';
import { Order } from '../../service/types';

import styles from './styles';

type Props = {
    route: {
        params: {
            order: Order;
        }
    }
}


const OrderDetails: React.FC<Props> = ({ route }: Props) => {

    const navigation = useNavigation();
    const { order } = route.params;

    const handleOnPress = () => {
        navigation.navigate('Orders');
    }
    const handleOnCancel = () => {
        navigation.navigate('Orders');
    }
    const handleConfirmDelivery = () => {
        confirmDelivery(order.id)
            .then(() => {
                Alert.alert(`Pedido ${ order.id } confirmado com sucesso`)
                navigation.navigate('Orders');
            })
            .catch(() => {
                Alert.alert(`Houve um erro ao confirmar o pedido ${order.id}`);
            })
    }

    const handleStartNavigation = () => {
        // Linking.openURL(`https://www.google.com/maps/dir/?api=1&travelmode=driving&dir_action=navigate&destination=${order.latitude},${order.longitude}`);
        Linking.openURL(`https://www.waze.com/ul?ll=${order.latitude}%2C${order.longitude}&navigate=yes&zoom=17`);
    }
    
    return (
        <>
            <Header />
            <View style={styles.container}>
                <OrderCard order={ order }/>
                <RectButton style={styles.button} onPress={ handleStartNavigation }>
                    <Text style={styles.buttonText}>INICIAR NAVEGAÇÃO</Text>
                </RectButton>
                <RectButton style={styles.button} onPress={ handleConfirmDelivery }>
                    <Text style={styles.buttonText}>CONFIRMAR ENTREGA</Text>
                </RectButton>
                <RectButton style={styles.button} onPress={ handleOnCancel }>
                    <Text style={styles.buttonText}>CANCELAR</Text>
                </RectButton>
            </View>
        </>
        
    );
}
export default OrderDetails;