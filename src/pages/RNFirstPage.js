import * as React from 'react';
import { View, Text,StyleSheet,Button,NativeModules} from 'react-native';

const { FirstModule} = NativeModules;
export default function RNFirstPage ({ navigation }){

    const secondPage = ()=>{
        console.log("secondPage====");
        navigation.navigate('second');
    }

    const startActivity = ()=>{
        console.log("startActivity====");
        FirstModule.testNative();
    }
    return (  <View style={styles.container}>
        <Text style={styles.textFont}>Rn First</Text>
        <Button
        title="Press me"
        onPress={secondPage}
      />

<Button
        title="start activity me"
        onPress={startActivity}
      />
    </View>);
}


const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: "center",
    },

    textFont:{
         
        textAlign: "center",
         
    }
  });
  