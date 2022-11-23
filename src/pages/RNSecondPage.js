import * as React from 'react';
import { View, Text,StyleSheet,Button} from 'react-native';



export default function RNSecondPage({ navigation }){
const firstPage = ()=>{
    console.log("firstPage");
    navigation.navigate('first');
}
    return (  <View style={styles.container}>
        <Text style={styles.textFont}>Rn second</Text>
        <Button
        title="second Press me"
        onPress={firstPage}
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