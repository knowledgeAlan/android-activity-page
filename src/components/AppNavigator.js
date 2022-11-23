import * as React from 'react';
import { View, Text,StyleSheet} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import RNFirstPage from "../pages/RNFirstPage";
import RNSecondPage from "../pages/RNSecondPage";



const HomeStack = createNativeStackNavigator();

export default function AppNavigator (){
    return (
        
           <NavigationContainer>
      <HomeStack.Navigator>
        <HomeStack.Screen name="first" component={RNFirstPage} />
        <HomeStack.Screen name="second" component={RNSecondPage} />
      </HomeStack.Navigator>
    </NavigationContainer>
      
      );
}


const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: "center",
    },
  });
  