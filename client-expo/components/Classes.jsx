import { Image, Text, View } from "react-native";
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
import ClassesElement from "./ClassesElement";

export default function Classes() {
    return (
        <View style={{
            flexDirection: 'row', width: '95%', borderRadius: 8, padding: 12, paddingTop: 18, paddingBottom: 18, alignContent: 'center', backgroundColor: '#FFFFFF', shadowColor: "#000",
            shadowOffset: { width: 0, height: 2, }, shadowOpacity: 0.08, shadowRadius: 2.22,
        }}>

            <View style={{flex: 1, flexDirection: 'column' }}>
                <View style={{ flex: 1, flexDirection: 'row', alignItems: 'center', margin: 3 }}>
                    <Icon name="calendar-month-outline" size={22} style={{  }} />
                    <Text style={{ fontSize: 15, marginLeft: 5 }}>Mi Matricula</Text>
                </View>
                <View style={{ height: 1, backgroundColor: '#F2F2F2', width: 365 }} />
                <View>
                    <ClassesElement />
                    <ClassesElement />
                    <ClassesElement />
                </View>
            </View>

        </View>
    );
}