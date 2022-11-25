import * as React from 'react';
import { View, Text,StyleSheet,Button,NativeModules,
    NativeEventEmitter,} from 'react-native';

const { FirstModule,CustomCameraModule} = NativeModules;
const firstModuleManagerEmitter = new NativeEventEmitter(FirstModule);
const firstModuleSubscription = firstModuleManagerEmitter.addListener(

    'EventAlipayCamera',
  
    (result) => console.log("firstModuleManagerEmitter ====",result)
  
  );
  
export default function RNFirstPage ({ navigation }){

    const secondPage = ()=>{
        console.log("secondPage====");
        navigation.navigate('second');
    }

    const startActivity = ()=>{
        console.log("startActivity====");
        FirstModule.testNative();
    }

    const startCameraActivity = ()=>{
        console.log("startCameraActivity====");
        CustomCameraModule.pickImage((res=>{
            console.log("startCameraActivity response==",res);
        }));
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

      <Button
        title="start camera activity "
        onPress={startCameraActivity}
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
  