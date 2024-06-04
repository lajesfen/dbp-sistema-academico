import { Image, Text, View } from "react-native";

export default function DataHeader() {
    return (
        <View style={{ flexDirection: 'row', width: '95%', borderRadius: 8, padding: 12, paddingTop: 18, paddingBottom: 18, alignContent: 'center', backgroundColor: '#FFFFFF', shadowColor: "#000",
        shadowOffset: { width: 0, height: 2, }, shadowOpacity: 0.08, shadowRadius: 2.22, }}>

            <Image source={require('../assets/image.png')} style={{ width: 60, height: 60, borderRadius: 100 }} />

            <View style={{ marginLeft: 12, flex: 1, justifyContent: 'center' }}>
                <View style={{ flexDirection: 'row' }}>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold' }}>Nombre Apellido Apellido</Text>
                        <Text style={{ marginTop: 4, fontSize: 11, color: '#BDBDBD' }}>202220401</Text>
                    </View>
                    <View style={{ flex: 1, justifyContent: 'center' }}>
                        <Text style={{ flexShrink: 1, fontSize: 11 }}>Ciencia de la Computacion - Facultad de Computacion</Text>
                    </View>
                </View>
            </View>
        </View>
    );
}