import { Image, View, ScrollView } from "react-native";
import DataHeader from "../components/DataHeader";
import Calendar from "../components/Calendar";
import Payments from "../components/Payments";

export default function HomeScreen() {
    return (
        <ScrollView contentContainerStyle={{ alignItems: 'center' }}>
            <Image source={require('../assets/dashboard-header.png')} style={{ width: '95%', resizeMode: 'contain' }} />
            <View style={{flex: 1, flexDirection: 'column', gap: 20 }}>
                <DataHeader />
                <Calendar />
                <Payments />
            </View>
        </ScrollView>
    )
}