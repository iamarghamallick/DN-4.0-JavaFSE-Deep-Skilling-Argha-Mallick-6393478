import React from 'react';
import Post from './Post'; // Assuming Post is a React component, not the class you showed

class Posts extends React.Component {
    constructor(props) {
        super(props);
        console.log("constructor called");
        this.state = {
            posts: [],
        };
    }

    loadPosts = async () => {
        console.log("loadPosts called");
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            const data = await response.json();
            this.setState({ posts: data.slice(0, 10) }); // fetch top 10 posts
        } catch (error) {
            throw new Error("Failed to load posts");
        }
    };

    componentDidMount() {
        console.log("componentDidMount called");
        this.loadPosts();
    }

    render() {
        console.log("render called");
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map((post) => (
                    <Post key={post.id} title={post.title} body={post.body} />
                ))}
            </div>
        );
    }

    componentDidCatch(error, info) {
        console.log("componentDidCatch called");
        alert("An error occurred: " + error.message);
    }
}

export default Posts;
