import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View,AppRegistry } from 'react-native';
import AppNavigator from './src/components/AppNavigator';
import RNFirstPage from "./src/pages/RNFirstPage";

AppRegistry.registerComponent('application', () => AppNavigator);
AppRegistry.registerComponent("RNFirstPage", () => RNFirstPage);
export default function App() {
  return (
    <AppNavigator/>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
