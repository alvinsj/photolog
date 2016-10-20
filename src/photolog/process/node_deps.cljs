(ns photolog.process.node-deps
  (:require [cljs.nodejs :as node]))

(def file-stat (.-stat (node/require "fs")))
(def read-dir (.-readdir (node/require "fs")))

(def write-file-sync (.-writeFileSync (node/require "fs")))
(def read-file-sync (.-readFileSync (node/require "fs")))
(def file-exists-sync (.-existsSync (node/require "fs")))
(def file-read-stream (.-createReadStream (node/require "fs")))
(def file-write-stream (.-createWriteStream (node/require "fs")))

(def resolve-path (let [resolve (.-resolve (node/require "path"))]
                    (fn [path] (when (string? path) (resolve path)))))
(def path-extension (.-extname (node/require "path")))
(def path-dirname (.-dirname (node/require "path")))
(def path-basename (let [basename (.-basename (node/require "path"))]
                     (fn [path] (basename path (path-extension path)))))

(def process-argv (.-argv (node/require "process")))
(def write-stdout (let [stdout (.-stdout (node/require "process"))]
                    (fn [output] (.write stdout output))))

(def exec-sync (.-execSync (node/require "child_process")))
(def sharp (node/require "sharp"))
