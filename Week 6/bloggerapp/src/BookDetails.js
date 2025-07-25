import React from 'react';

function BookDetails({ books }) {
    return (
        <div className="component-card">
            <h1>Book Details</h1>
            {books.map(book => (
                <div key={book.id} className="item-card">
                    <h3>{book.bname}</h3>
                    <p>{book.price}</p>
                </div>
            ))}
        </div>
    );
}

export default BookDetails;