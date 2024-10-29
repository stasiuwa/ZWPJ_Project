import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import {useData} from "../../contexts/DataContext";
import {deletePost} from "../../api/services/Post";


const PostTable = (props) => {
    const data = useData();
    const navigate = useNavigate();
    const [currentPage, setCurrentPage] = useState(1);
    const [perPage, setPerPage] = useState(15);

    // TODO undefined
    const allPosts = props.data.cars.flatMap((car) =>
        car.posts.map((post) => ({ ...post, carID: car.id }))
    );
    const indexOfFirstPost = (currentPage - 1) * perPage;
    const indexOfLastPost = indexOfFirstPost + perPage;
    const currentPosts = allPosts.slice(indexOfFirstPost, indexOfLastPost);

    const deleteButton = async (carID, postID) => {
        await deletePost(carID, postID);
        alert("Usunieto wpis!");
        await data.loadPosts(carID);
    }

    return (
        <div>
            <div style={{
                padding: '2%',
            }}>
                <button className={'btn btn-light'}
                        onClick={() => setCurrentPage(currentPage - 1)}
                        disabled={currentPage === 1}>
                    Poprzednia strona
                </button>
                <button className={'btn btn-light'} style={{marginLeft: '1vw'}}
                        onClick={() => setCurrentPage(currentPage + 1)}
                        disabled={indexOfLastPost >= props.data.cars.length}>
                    Następna strona
                </button>
            </div>
            <table className={'table table-dark table-responsive-xxl'}>
                <thead>
                <tr>
                    <th>Typ</th>
                    <th>Data</th>
                    <th>Przebieg</th>
                    <th>Szczegóły</th>
                    <th>Cena</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {currentPosts.map((post) => (
                    <tr key={post.id}>
                        <td>{post.type}</td>
                        <td>{post.date}</td>
                        <td>{post.mileage}</td>
                        <td>{post.details}</td>
                        <td>{post.price}</td>
                        <td>
                            <button className={'btn btn-dark'} style={{color: 'blue'}}
                                    onClick={() => navigate(`/vGarage/myCars/${post.carID}/posts/${post.id}`)}>SZCZEGÓŁY</button>
                        </td>
                        <td>
                            <button className={'btn btn-dark'} style={{color: 'red'}}
                                    onClick={() => deleteButton(post.carID, post.id)}>USUŃ</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default PostTable;