import { Image, ScrollView, View } from 'react-native';
import CurricularHeader from '../components/CurricularHeader';
import Classes from '../components/Classes';

export default function CurricularScreen() {
    return (
        <ScrollView contentContainerStyle={{ alignItems: 'center', marginTop: 20 }}>
            <View style={{flex: 1, flexDirection: 'column', gap: 20 }}>
                <CurricularHeader />
                <Classes />
            </View>
        </ScrollView>
    )
}