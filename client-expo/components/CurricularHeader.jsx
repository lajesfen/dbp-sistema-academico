import { Image, Text, View } from "react-native";

export default function CurricularHeader() {
    return (
        <View style={{ flexDirection: 'row', width: '95%', borderRadius: 8, padding: 12, paddingTop: 18, paddingBottom: 18, alignContent: 'center', backgroundColor: '#FFFFFF', shadowColor: "#000",
        shadowOffset: { width: 0, height: 2, }, shadowOpacity: 0.08, shadowRadius: 2.22, }}>

            <Image source={require('../assets/image.png')} style={{ width: 60, height: 60, borderRadius: 10 }} />

            <View style={{ marginLeft: 12, flex: 1, justifyContent: 'center' }}>
                <View style={{ flexDirection: 'row' }}>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold', fontSize: 10 }}>Nombre del alumno:</Text>
                        <Text style={{ marginTop: 4, fontSize: 11 }}>Luciano Aguirre Jesfen</Text>
                    </View>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold', fontSize: 10 }}>Periodo de  ingreso:</Text>
                        <Text style={{ marginTop: 4, fontSize: 11 }}>2022-2</Text>
                    </View>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold', fontSize: 10 }}>Carrera:</Text>
                        <Text style={{ marginTop: 4, fontSize: 11 }}>Ciencia de la Computación - Facultad de Computación</Text>
                    </View>
                </View>
                <View style={{ flexDirection: 'row', marginTop: 15 }}>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold', fontSize: 10 }}>Orden de mérito:</Text>
                        <Text style={{ marginTop: 4, fontSize: 11 }}>1000</Text>
                    </View>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold', fontSize: 10 }}>Promedio ponderado:</Text>
                        <Text style={{ marginTop: 4, fontSize: 11 }}>20</Text>
                    </View>
                    <View style={{ flex: 1 }}>
                        <Text style={{ flexShrink: 1, fontWeight: 'bold', fontSize: 10 }}>Orden de mérito de la carrera:</Text>
                        <Text style={{ marginTop: 4, fontSize: 11 }}>10000</Text>
                    </View>
                </View>
            </View>
        </View>
    );
}