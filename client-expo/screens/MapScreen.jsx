import React, { useEffect, useState } from 'react';
import { View, Button, Text, Image } from 'react-native';
import MapView, { Marker } from 'react-native-maps';
import MapViewDirections from 'react-native-maps-directions';
import UtecMarker from '../assets/utec_map.png';

import * as Location from 'expo-location';

export default function MapScreen() {
    const [location, setLocation] = useState(null);

    useEffect(() => {
        (async () => {

            let { status } = await Location.requestForegroundPermissionsAsync();
            if (status !== 'granted') {
                setErrorMsg('Permission to access location was denied');
                return;
            }

            let location = await Location.getCurrentPositionAsync({});
            setLocation(location);
        })();
    }, []);

    const destination = { latitude: -12.135211992201363, longitude: -77.02213279918004 };
    const GOOGLE_MAPS_APIKEY = 'AIzaSyD9KP45GtfIq_7D9Ugc5JHLtctzgV1n_Ow';

    if (!location) {
        return (
            <View>
            </View>
        );
    }

    return (
        <MapView style={{ width: '100%', height: '100%' }} region={{
            latitude: location.coords.latitude,
            longitude: location.coords.longitude,
            latitudeDelta: 0.005,
            longitudeDelta: 0.005,
        }}
            mapType='mutedStandard' showsUserLocation={true}>
            <Marker
                key={'utec_map_marker'}
                coordinate={destination}
                title={'UTEC'}
                description={'Universidad de Ingeniería y Tecnología'}
                image={{ uri: Image.resolveAssetSource(UtecMarker).uri, width: 5, height: 5 }}
            />
            <MapViewDirections
                origin={{ latitude: location.coords.latitude, longitude: location.coords.longitude }}
                destination={destination}
                apikey={GOOGLE_MAPS_APIKEY}
                strokeWidth={3}
                strokeColor='#00BFFF'
                language="ES"
            />
        </MapView >
    );
}