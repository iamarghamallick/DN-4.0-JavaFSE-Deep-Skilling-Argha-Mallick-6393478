import React from 'react';

function BlogDetails({ blogs }) {
    return (
        <div className="component-card">
            <h1>Blog Details</h1>
            {blogs.map(blog => (
                <div key={blog.id} className="item-card">
                    <h2>{blog.title}</h2>
                    <p><strong>{blog.author}</strong></p>
                    <p>{blog.content}</p>
                </div>
            ))}
        </div>
    );
}

export default BlogDetails;