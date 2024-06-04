import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import HomeScreen from './HomeScreen';
import CurricularScreen from './CurricularScreen';
import ToDoScreen from './ToDoScreen';
import { Image } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome5';
import MapScreen from './MapScreen';

const Tab = createBottomTabNavigator();

export default function Tabs() {
    return (
        <Tab.Navigator>
            <Tab.Screen name="Inicio" component={HomeScreen} options={({ navigation }) => ({
                tabBarIcon: ({ focused }) => {
                    return <Icon name="home" size={22} color={focused ? "#00BFFF" : "#BDBDBD"} />
                },
                headerTitle: () => (
                    <Image
                        source={require('../assets/icon.png')}
                        style={{ width: 30, height: 30, resizeMode: 'contain' }}
                    />
                ),
                headerLeft: () => (
                    <Icon name="bars" size={22} color="#00BFFF" style={{ marginLeft: 30 }} />
                )
            })} />
            <Tab.Screen name="Curricula" component={CurricularScreen} options={{
                tabBarIcon: ({ focused }) => (
                    <Icon name="graduation-cap" size={22} color={focused ? "#00BFFF" : "#BDBDBD"} />
                ),
                headerTitle: () => (
                    <Image
                        source={require('../assets/icon.png')}
                        style={{ width: 30, height: 30, resizeMode: 'contain' }}
                    />
                ),
                headerLeft: () => (
                    <Icon name="bars" size={22} color="#00BFFF" style={{ marginLeft: 30 }} />
                )
            }} />
            <Tab.Screen name="Consultas" component={ToDoScreen} options={{
                tabBarIcon: ({ focused }) => (
                    <Icon name="search" size={22} color={focused ? "#00BFFF" : "#BDBDBD"} />
                ),
                headerTitle: () => (
                    <Image
                        source={require('../assets/icon.png')}
                        style={{ width: 30, height: 30, resizeMode: 'contain' }}
                    />
                )
            }} />
            <Tab.Screen name="Tramites" component={ToDoScreen} options={{
                tabBarIcon: ({ focused }) => (
                    <Icon name="file-invoice" size={22} color={focused ? "#00BFFF" : "#BDBDBD"} />
                ),
                tabBarBadge: 3,
                headerTitle: () => (
                    <Image
                        source={require('../assets/icon.png')}
                        style={{ width: 30, height: 30, resizeMode: 'contain' }}
                    />
                )
            }}
            />
            <Tab.Screen name="Mapa" component={MapScreen} options={{
                tabBarIcon: ({ focused }) => (
                    <Icon name="map-marked-alt" size={22} color={focused ? "#00BFFF" : "#BDBDBD"} />
                )
            }}/>
        </Tab.Navigator>
    );
}