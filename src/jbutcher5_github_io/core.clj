(ns jbutcher5-github-io.core
  (:gen-class)
  (:require [hiccup.page :refer [html5 include-css]]
            [clojure.java.io :refer [writer]]))

(def index
  (html5
   [:head
    [:title "James' Portfolio"]
    (include-css "output.css")]
   [:body
    [:h1 "Lorem Ipsum"]]))

(def pages [["index" index]])

(defn write-pages [pages]
  (let [x (first pages) xs (rest pages)]
    (with-open [wtr (writer (str (first x) ".html"))]
      (.write wtr (second x)))
    (when (> (count xs) 0) (write-pages xs))))

(defn -main
  [& _]
  (write-pages pages))
