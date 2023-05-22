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
    [:p.text-white.text-4xl.p-4.font-bold.text-center.underline.decoration-wavy "Hi, I'm James"]
    [:p#text-block.py-4 "I enjoy programming and here are some of my interests:"
     [:ul.list-disc.list-inside
      (map
       (fn [x] [:li#text-block x])
       ["Compilers/Interpreters"
        "Procedual Generation"
        "Functional Programming"
        "Low-level Programming"])]]
    [:p#text-block.py-4 "Here are some of my favourite programming languages:"
     [:ul.list-decimal.list-inside
      (map
       (fn [x] [:li#text-block x])
       ["Scheme"
        "C"
        "Rust"
        "Clojure"
        "D"])]]]))

(def pages [["index" index]])

(defn write-pages [pages]
  (let [x (first pages) xs (rest pages)]
    (with-open [wtr (writer (str (first x) ".html"))]
      (.write wtr (second x)))
    (when (> (count xs) 0) (write-pages xs))))

(defn -main
  [& _]
  (write-pages pages))
