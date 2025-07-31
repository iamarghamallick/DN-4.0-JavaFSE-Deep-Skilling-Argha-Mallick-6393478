import React, { Component } from 'react';
import CourseDetails from './CourseDetails';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import { courses, books, blogs } from './data';
import './App.css';

class App extends Component {
  state = {
    showCourses: true,
    showBooks: true,
    showBlogs: true,
  };

  toggle = (component) => {
    this.setState((prevState) => ({ [component]: !prevState[component] }));
  };

  render() {
    const { showCourses, showBooks, showBlogs } = this.state;
    let blogComponent;
    if (showBlogs) {
      blogComponent = <BlogDetails blogs={blogs} />;
    }

    return (
      <div>
        <div className="controls">
          <button onClick={() => this.toggle('showCourses')}>Toggle Courses</button>
          <button onClick={() => this.toggle('showBooks')}>Toggle Books</button>
          <button onClick={() => this.toggle('showBlogs')}>Toggle Blogs</button>
        </div>

        <div className="app-container">
          {showCourses ? (
            <CourseDetails courses={courses} />
          ) : (
            <div className="placeholder">Courses Hidden</div>
          )}
          {showBooks && <BookDetails books={books} />}
          {blogComponent || <div className="placeholder">Blogs Hidden</div>}
        </div>
      </div>
    );
  }
}

export default App;