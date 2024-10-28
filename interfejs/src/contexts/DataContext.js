import React, {createContext, useContext, useState} from 'react';
import {getAllCars} from "../api/services/Car";
import {getUser} from "../api/services/User";
import {getAllPosts, getPosts} from "../api/services/Post";

const DataContext = createContext();

export const DataProvider = ({ children }) => {
    const [cars, setCars] = useState([]);
    const [posts, setPosts] = useState([]);
    const [user, setUser] = useState({});
    const [error, setError] = useState(null);

    /**
     * Wczytuje dane z bazy danych za pomoca funkcji z ../api/services/ i zapisuje je do zmiennych
     */

    const loadAllPosts = async () => {
        const fetchPosts = async () => {
            try {
                const response = await getAllPosts();
                setPosts(response)
            } catch (error){
                setError(error.response ? error.response.data : error.message);
            }
        }
        await fetchPosts();
    }
    const loadPosts = async (carID) => {
        const fetchPosts = async (carID) => {
            try {
                const response = await getPosts(carID);
                setPosts(response);
            } catch (error) {
                setError(error.response ? error.response.data : error.message);
            }
        }
        await fetchPosts(carID);
    }
    const loadData = async() => {
        const fetchCars = async () => {
            try {
                const response = await getAllCars();
                setCars(response.data);
            } catch (error) {
                setError(error.response ? error.response.data : error.message);
            }
        };

        const fetchUser = async () => {
            try {
                const response = await getUser();
                setUser(response.data);
            } catch (error) {
                setError(error.response ? error.response.data : error.message);
            }
        }
        fetchUser().then(fetchCars);
    }

    const data = {user, cars, posts, error, loadData, loadAllPosts, loadPosts};

    return (
        <DataContext.Provider value={data}>
            {children}
        </DataContext.Provider>
    );
};

export const useData = () => {
    return useContext(DataContext);
};
