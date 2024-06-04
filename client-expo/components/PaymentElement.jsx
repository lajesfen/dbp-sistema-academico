import { Image, Text, View } from "react-native";
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';

export default function PaymentElement() {
    return (
        <View style={{
            flexDirection: 'row', borderRadius: 8, padding: 12, margin: 4, backgroundColor: '#FFFFFF', shadowColor: "#000",
            shadowOffset: { width: 0, height: 2, }, shadowOpacity: 0.08, shadowRadius: 2.22, alignItems: 'center'
        }}>
            <View style={{ flex: 1, flexDirection: 'column' }}>
                <Text>
                    Cuota 1 2023-2
                </Text>
                <Text style={{ color: '#BDBDBD', fontSize: 11, marginTop: 3 }}>
                    08/10/2023
                </Text>
            </View>
            <Text>
                S/. 1000.50
            </Text>
        </View>
    );
}