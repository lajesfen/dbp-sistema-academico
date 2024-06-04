import { StyleSheet, View, Button, Image } from 'react-native';
import { useAsyncStorage } from '@react-native-async-storage/async-storage';
import { useState, useEffect } from 'react';
import * as Google from 'expo-auth-session/providers/google';
import * as WebBrowser from 'expo-web-browser';
import { NavigationContainer } from '@react-navigation/native/';
import Tabs from './screens/Tabs';

WebBrowser.maybeCompleteAuthSession();

export default function App() {
  const [userInfo, setUsetInfo] = useState(null);

  const [request, response, promptAsync] = Google.useAuthRequest({
    webClientId: "678532649216-60fgonfb1i81388umvcjtfgcsk0h8asp.apps.googleusercontent.com",
    iosClientId: "678532649216-m0a1v072vkel3gp3eku7na9bhvnusp60.apps.googleusercontent.com",
    androidClientId: "678532649216-qlb22trig0ft5a8uhgcu0b8gj8kr85vn.apps.googleusercontent.com"
  });

  useEffect(() => {
    handleSignIn();
  }, [response]);

  async function handleSignIn() {
    const user = await useAsyncStorage('@user').getItem();
    if (!user) {
      if (response?.type === 'success') {
        await getUserInfo(response.authentication.accessToken);
      }
    } else {
      setUsetInfo(JSON.parse(user));
    }
  }

  const getUserInfo = async (accessToken) => {
    if (!accessToken) return;
    try {
      const response = await fetch(
        "https://www.googleapis.com/userinfo/v2/me",
        {
          headers: { Authorization: `Bearer ${accessToken}` },
        }
      );

      const user = await response.json();
      await useAsyncStorage('@user').setItem(JSON.stringify(user));
      setUsetInfo(user);
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <NavigationContainer>
      <View style={styles.container}>
        <Tabs />
      </View>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    items: 'center',
    justifyContent: 'center',
  }
});