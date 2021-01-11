import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import Home from './pages/Home';
import Orders from './pages/Orders';

const AppStack = createStackNavigator();

const Routes: React.FC = () => {
  return (
        <NavigationContainer>
            
            <AppStack.Navigator 
                headerMode="none"
                screenOptions={{
                    cardStyle: {
                        backgroundColor:'#FFF'
                    }
                }}>
            <AppStack.Screen name="Home" component={ Home } />
            <AppStack.Screen name="Orders" component={ Orders } />
            </AppStack.Navigator>
        </NavigationContainer> 
  );
}

export default Routes;