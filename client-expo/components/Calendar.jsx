import { Image, Text, View } from "react-native";
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';

export default function Calendar() {
    return (
        <View style={{
            flexDirection: 'row', width: '95%', borderRadius: 8, padding: 12, paddingTop: 18, paddingBottom: 18, alignContent: 'center', backgroundColor: '#FFFFFF', shadowColor: "#000",
            shadowOffset: { width: 0, height: 2, }, shadowOpacity: 0.08, shadowRadius: 2.22,
        }}>

            <View style={{flex: 1, flexDirection: 'column' }}>
                <View style={{ flex: 1, flexDirection: 'row', alignItems: 'center', margin: 3 }}>
                    <Icon name="calendar-month-outline" size={22} style={{  }} />
                    <Text style={{ fontSize: 15, marginLeft: 5 }}>Mi Horario</Text>
                </View>
                <View style={{ height: 1, backgroundColor: '#F2F2F2', width: 365 }} />
                <View style={{flex: 1}}>
                    <Image source={require('../assets/calendar-element.png')} style={{ width: '100%', resizeMode: 'contain' }} />
                </View>
            </View>

        </View>
    );
}