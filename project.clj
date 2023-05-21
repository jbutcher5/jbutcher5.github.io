(defproject jbutcher5-github-io "0.1.0"
  :description "A static personal website"
  :url "https://jbutcher5.github.io"
  :license {:name "MIT"
            :url "https://mit-license.org/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot jbutcher5-github-io.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
